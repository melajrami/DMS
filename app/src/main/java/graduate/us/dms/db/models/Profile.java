package graduate.us.dms.db.models;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by MyLabtop on 4/23/2015.
 */

@Table(name = "Profile", id = "_ID")
public class Profile extends BaseModel {
    public Profile(){super();}

    @Column(name = "Name")
    public String Name;

    @Column
    public String Password;

    @Column
    public String Email;

    @Column
    public int MobileNo;

    @Column
    public int Age;

    @Column
    public String Gender;

    @Column
    public String DiabetesType;

    @Column
    public String AccountType;

    @Column
    public int Weight;

    @Column
    public int Height;

    @Column
    public int UpperLimitBM;

    @Column
    public int UpperLimitAM;

    @Column
    public int LowerLimit;

    @Column
    public int Sync_Status_Id;



}
