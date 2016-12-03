package com.example.android.pets.data;

import android.content.ContentResolver;
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

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of pets.
         * You’ll notice that we’re making use of the constants defined in the ContentResolver class:
         * CURSOR_DIR_BASE_TYPE (which maps to the constant "vnd.android.cursor.dir") and CURSOR_ITEM_BASE_TYPE (which
         * maps to the constant “vnd.android.cursor.item”).
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single pet.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;


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

        /**
         * Returns whether or not the given gender is {@link #GENDER_UNKNOWN}, {@link #GENDER_MALE},
         * or {@link #GENDER_FEMALE}.
         */
        public static boolean isValidGender(int gender) {
            if (gender == GENDER_UNKNOWN || gender == GENDER_MALE || gender == GENDER_FEMALE) {
                return true;
            }
            return false;
        }
    }
}
