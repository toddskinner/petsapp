package com.example.android.pets.data;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by toddskinner on 11/30/16.
 */

public final class PetContract {

    public static final String CONTENT_AUTHORITY = "com.example.android.pets";
    //we use the parse method which takes in a URI string and returns a Uri which will be shared by every URI associated with PetContract:
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    //Stores the path for each of the tables which will be appended to the base content URI.
    public static final String PATH_PETS = "pets";

    public static abstract class PetEntry implements BaseColumns {

        //create a full URI for the class as a constant called CONTENT_URI
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PETS);

        public static final String TABLE_NAME = "pets";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_PET_NAME = "name";
        public static final String COLUMN_PET_BREED = "breed";
        public static final String COLUMN_PET_GENDER = "gender";
        public static final String COLUMN_PET_WEIGHT = "weight";

        /**
         * Possible values for the gender of the pet.
         */
        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;

    }
}
