package graduate.us.dms.ConstantApp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by MyLabtop on 4/21/2015.
 */
public class ConstantVariable {

    public enum Category {
        Dashboard(10),
        Glucose(20),
        Food(30),
        Training(40),
        Medication(50),
        Statistics(60),
        Reminders(70),
        Settings(80),

        Profile(100);

        public int id;

        private Category(int id) {
            this.id = id;
        }
    }

    public enum CloudStatus {
        Normal(0),
        NeedUpload(1),
        NeedDownload(2);
        public int id;

        private CloudStatus(int id) {
            this.id = id;
        }
    }

    public static String getDateString(Date date) {
        if (date == null)
            return "";
        return SimpleDateFormat.getDateInstance(SimpleDateFormat.LONG, java.util.Locale.getDefault()).format(date);
    }

    public static String getTimeString(Date date) {
        if (date == null)
            return "";
        DateFormat formatter = new SimpleDateFormat("hh:mm: aa");
        return formatter.format(date);
    }

    public static Date getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        TimeZone tz = TimeZone.getDefault();
        calendar.add(Calendar.MILLISECOND, tz.getOffset(calendar.getTimeInMillis()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currenTimeZone = new Date((long) 1379487711 * 1000);
        return currenTimeZone;
    }

    public static int getCurrentDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        TimeZone tz = TimeZone.getDefault();
        calendar.add(Calendar.MILLISECOND, tz.getOffset(calendar.getTimeInMillis()));
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        return day;
    }

}
