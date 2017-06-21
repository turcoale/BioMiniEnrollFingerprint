package models;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Користувач on 21.06.2017.
 */
public enum Messages {
    Success(0),
    GetScannerHandleFail(-1),
    SingleImageFail(-212),
    GetImageFail(-2),
    UnknownError(-99);

    private final int code;


    Messages(int code) {
        this.code = code;
    }

    public int getCode(){
        return code;
    }


    public static Messages getMessage(int code){
        return Arrays.stream(values())
                .filter(e->e.getCode()==code)
                .findFirst()
                .orElse(UnknownError);
    }
}
