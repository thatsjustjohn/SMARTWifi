package com.example.android.smartwifi.data.geofencedb;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by jtwyp6 on 10/29/17.
 */

public class GeofenceContract {

    /* Add content provider constants to the Contract
     Clients need to know how to access the task data, and it's your job to provide
     these content URI's for the path to that data:
        1) Content authority,
        2) Base content URI,
        3) Path(s) to the tasks directory
        4) Content URI for data in the TaskEntry class
      */

    // The authority, which is how your code knows which Content Provider to access
    public static final String AUTHORITY = "com.example.android.smartwifi.geofence";

    // The base content URI = "content://" + <authority>
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    // Define the possible paths for accessing data in this contract
    // This is the path for the "tasks" directory
    public static final String PATH_GEOFENCES = "geofences";


    /* TaskEntry is an inner class that defines the contents of the task table */
    public static final class GeofenceEntry implements BaseColumns {

        // TaskEntry content URI = base content URI + path
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_GEOFENCES).build();


        // Task table and column names
        public static final String TABLE_NAME = "geofences";

        // Since TaskEntry implements the interface "BaseColumns", it has an automatically produced
        // "_ID" column in addition to the two below
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_LATITUDE = "lat";
        public static final String COLUMN_LONGITUDE = "long";
        public static final String COLUMN_RADIUS = "radius";


        /*
        The above table structure looks something like the sample table below.
        With the name of the table and columns on top, and potential contents in rows

        Note: Because this implements BaseColumns, the _id column is generated automatically

        GeoFences
         - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        | _id  |    description     |      lat      |   long   |    radius     |
         - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        |  1   |        Home        |    100.000    |  33.0000 |      30       |
         - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        |  2   |        Work        |    110.000    |  43.0001 |      50       |
         - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

         */

    }
}
