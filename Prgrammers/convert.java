import java.io.*;
import java.util.*;

public class convert {

	public static void main(String[] args) {
		String str = "[[2,6,6], [6,3,7], [4,6,7], [6,5,11], [2,5,12], [5,3,20], [2,4,8], [4,3,9]]";
		
		str = str.replace("[", "{");
		str = str.replace("]", "}");
		
		System.out.println(str);
	}

}
