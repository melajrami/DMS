package graduate.us.dms.db.dal;

import graduate.us.dms.ConstantApp.AppLog;
import graduate.us.dms.db.models.BaseModel;
import graduate.us.dms.db.models.SyncDeleted;

/**
 * Created by Tareq on 03/04/2015.
 */
public class BaseDao  {


    public void DeleteSyncer(BaseModel obj){
        if(obj.RemoteID!=null && obj.RemoteID!=0)
        {
            SyncDeleted sync=new SyncDeleted();
            sync.ObjectID=obj.RemoteID;
            sync.ObjectName=obj.getClass().getName();
            AppLog.i( "Delete from " + sync.ObjectName + " id=>" + sync.ObjectID);
            sync.save();
        }
    }
}
