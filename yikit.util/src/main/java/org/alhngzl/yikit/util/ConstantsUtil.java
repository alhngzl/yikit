package org.alhngzl.yikit.util;

public class ConstantsUtil {
    private ConstantsUtil() {throw new IllegalStateException(ConstantsUtil.class.getName());}

    public static class Char{
        private Char() {throw new IllegalStateException(Char.class.getName());}
        public static final String EMPTY = "";
        public static final String COLON = " : ";
        public static final String EQUAL = " = ";
        public static final String ASCI_EQUALS = "\\u003d";
    }

    public static class EmailDefinition{
        private EmailDefinition() {throw new IllegalStateException(EmailDefinition.class.getName());}
        public static class CreateUser{
            private CreateUser() {throw new IllegalStateException(CreateUser.class.getName());}
            public static final String MAIL_FROM     = "alhn.gzl@gmail.com";
            public static final String MAIL_TO       = "alhn.gzl@gmail.com";
            public static final String MAIL_SUBJECT  = "New User Created";
            public static final String MAIL_BODY     = "YikiT new user created just now. User info : ";
        }

        public static class ListUser{
            private ListUser() {throw new IllegalStateException(ListUser.class.getName());}
            public static final String MAIL_FROM     = "alhn.gzl@gmail.com";
            public static final String MAIL_TO       = "alhn.gzl@gmail.com";
            public static final String MAIL_SUBJECT  = "User Listed";
            public static final String MAIL_BODY     = "YikiT user listed just now. User info : ";
        }

        public static class DeleteUser{
            private DeleteUser() {throw new IllegalStateException(DeleteUser.class.getName());}
            public static final String MAIL_FROM     = "alhn.gzl@gmail.com";
            public static final String MAIL_TO       = "alhn.gzl@gmail.com";
            public static final String MAIL_SUBJECT  = "User Deleted";
            public static final String MAIL_BODY     = "YikiT user deleted just now. User info : ";
        }
    }
}
