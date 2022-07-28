package com.springboot.edu.springbootEdu.common;

public class Constants {
    // Exception 처리를 위한 Enum !
    public enum ExceptionClass {
        PRODUCT("Product"), ORDER("Order"), PROVIDER("Provider");

        private String exceptionClass;

        ExceptionClass(String exceptionClass) {
            this.exceptionClass = exceptionClass;
        }

        public String getExceptionClass() {
            return exceptionClass;
        }

        @Override
        public String toString() {
            return getExceptionClass() + " Exception ";
        }
    }
}
