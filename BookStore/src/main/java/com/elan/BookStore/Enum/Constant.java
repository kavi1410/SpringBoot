package com.elan.BookStore.Enum;

public class Constant
{
    public enum userType{
       Normal("normal"),Admin("admin");

        public String value;
        userType(String value ){
           this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
}
