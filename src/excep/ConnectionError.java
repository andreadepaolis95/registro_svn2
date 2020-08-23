package excep;



    public class ConnectionError extends Exception {

        private final int status = 500;



        public ConnectionError(){
            super();
        }

        public int getStatus() {
            return status;
        }
    }


