package graduate.us.dms.db.dal;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;

import java.util.List;

import graduate.us.dms.ConstantApp.AppLog;
import graduate.us.dms.db.models.Profile;
import graduate.us.dms.services.BusinessRoleError;

/**
 * Created by MyLabtop on 4/23/2015.
 */
public class ProfileDao extends BaseDao {
    public Profile getById(long id) {
        return Profile.load(Profile.class, id);
    }

    public void Add(String name, String password, String email,int mobileNo, int age, String gender, String diabetesType ,String accountType, int weight,int height,int upperLimitBM,int upperLimitAM, int lowerLimit) throws BusinessRoleError {

        AddEdit(null, name, password, email, mobileNo, age, gender, diabetesType,accountType, weight,height,upperLimitBM,upperLimitAM,lowerLimit);
    }

    public void Edit(long ID, String name, String password, String email,int mobileNo, int age, String gender, String diabetesType ,String accountType, int weight,int height,int upperLimitBM,int upperLimitAM, int lowerLimit) throws BusinessRoleError {
        AppLog.i("Edit => " + ID);
        AddEdit(ID, name, password, email, mobileNo, age, gender, diabetesType,accountType, weight,height,upperLimitBM,upperLimitAM,lowerLimit);
    }

    private void AddEdit(Long ID, String name, String password, String email,int mobileNo, int age, String gender, String diabetesType ,String accountType, int weight,int height,int upperLimitBM,int upperLimitAM, int lowerLimit) throws BusinessRoleError {
        Profile profile = null;
        if (ID != null && ID != 0)
            profile = Profile.load(Profile.class, ID.longValue());
        else
            profile = new Profile();

        profile.Name = name;
        profile.Password = password;
        profile.Email = email;
        profile.MobileNo = mobileNo;
        profile.Age = age;
        profile.Gender = gender;
        profile.DiabetesType = diabetesType;
        profile.Weight = weight;
        profile.Height = height;
        profile.UpperLimitBM = upperLimitBM;
        profile.UpperLimitAM = upperLimitAM;
        profile.LowerLimit = lowerLimit;
      // Calendar startDateCal = Calendar.getInstance();
       // startDateCal.setTimeInMillis(startDate);
       // course.StartDate = startDateCal.getTime();

      //  Calendar endDateCal = Calendar.getInstance();
      //  endDateCal.setTimeInMillis(endDate);
     //   course.EndDate = endDateCal.getTime();

 //Rules Ya Marwan
        /*
        // BR_CRS_007
        if (endDate < startDate)
            throw new BusinessRoleError(R.string.BR_CRS_007);

        // BR_CRS_001

        // The problem occurred when executing select object with the same type of the saved object,
        // because the object which we want to save is found in the result of select.

        long cCount;
        if (ID != null && ID != 0)
            cCount = new Select().from(Course.class).where("Name=? AND _ID!=?", name, course.getId()).count();
        else
            cCount = new Select().from(Course.class).where("Name=?", name).count();
        AppLog.i(cCount + " soso");
        if (cCount > 0)
            throw new BusinessRoleError(R.string.BR_CRS_001);

        // BR_CRS_012
//        cCount = getConflictCourses(course, ID);
//        if (cCount > 0)
//            throw new BusinessRoleError(R.string.BR_CRS_012);

        // BR_CRS_003
        if ((startDate < semester.StartDate.getTime()) || (endDate > semester.EndDate.getTime()))
            throw new BusinessRoleError(R.string.BR_CRS_003);
*/
        long result = profile.save();
        AppLog.i("Result: row " + profile.Name + " added, result id >" + result);
    }

    public void delete(long Id) throws BusinessRoleError {

        Profile profile = Profile.load(Profile.class, Id);
       // List<Note> cNotes = new NoteDao().getNotesWithinCourse(course);
      //  List<Exam> cExams = new ExamDao().getExamsWithinCourse(course);
      //  List<Task> cTasks = new TaskDao().getTasksWithinCourse(course);
/*
        if (cNotes != null && cNotes.size() > 0)
            throw new BusinessRoleError(R.string.BR_CRS_004);
        else if (cExams != null && cExams.size() > 0)
            throw new BusinessRoleError(R.string.BR_CRS_006);
        else if (cTasks != null && cTasks.size() > 0)
            throw new BusinessRoleError(R.string.BR_CRS_005);
*/

        ActiveAndroid.beginTransaction();
        try {
            DeleteSyncer(profile);

            profile.delete();
            ActiveAndroid.setTransactionSuccessful();
        } catch (Exception ex) {
            throw new BusinessRoleError("Can't delete");
        } finally {
            ActiveAndroid.endTransaction();
        }

    }

    public static List<Profile> getAll() {
        return new Select()
                .from(Profile.class)
                .orderBy("Name ASC")
                .execute();
    }


}