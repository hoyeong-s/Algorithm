import java.io.*;
import java.util.*;

public class convert {

	public static void main(String[] args) {
		String str = "[[0,0,0,1],[2,0,0,1],[4,0,0,1],[0,1,1,1],[1,1,1,1],[2,1,1,1],[3,1,1,1],[2,0,0,0],[1,1,1,0],[2,2,0,1]]";
		
		str = str.replace("[", "{");
		str = str.replace("]", "}");
		
		System.out.println(str);
	}

}
