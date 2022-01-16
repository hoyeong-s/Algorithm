import java.io.*;
import java.util.*;

public class convert {

	public static void main(String[] args) {
		String str = "";
		
		str = str.replace("[", "{");
		str = str.replace("]", "}");
		
		System.out.println(str);
	}

}
