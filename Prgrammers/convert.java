import java.io.*;
import java.util.*;

public class convert {

	public static void main(String[] args) {
		String str = "[[1,0,0,3],[2,0,0,0],[0,0,0,2],[3,0,1,0]]	";
		
		str = str.replace("[", "{");
		str = str.replace("]", "}");
		
		System.out.println(str);
	}

}
