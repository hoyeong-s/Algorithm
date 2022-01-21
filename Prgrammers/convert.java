import java.io.*;
import java.util.*;

public class convert {

	public static void main(String[] args) {
		String str = "[[0,1],[0,2],[1,3],[1,4],[2,5],[2,6],[3,7],[4,8],[6,9],[9,10]]";
		
		str = str.replace("[", "{");
		str = str.replace("]", "}");
		
		System.out.println(str);
	}

}
