package org.hurelhuyag.pocketbudget.web.domain;

/**
 * User: hurelhuyag
 * Email: hurle0409@gmail.com
 * Date: 11/25/12
 * Time: 5:27 PM
 */
public enum Type {
    INCOME(1),OUTCOME(2);

    final int value;

    Type(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static Type valueOf(int value){
        switch (value){
            case 1:
                return INCOME;
            case 2:
                return OUTCOME;
            default:
                throw new IllegalStateException("Not supported value ("+value+")");
        }
    }
}
