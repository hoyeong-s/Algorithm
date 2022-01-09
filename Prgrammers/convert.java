import java.io.*;
import java.util.*;

public class convert {

	public static void main(String[] args) {
		String str = "[[\"100\",\"ryan\",\"music\",\"2\"],[\"200\",\"apeach\",\"math\",\"2\"],[\"300\",\"tube\",\"computer\",\"3\"],[\"400\",\"con\",\"computer\",\"4\"],[\"500\",\"muzi\",\"music\",\"3\"],[\"600\",\"apeach\",\"music\",\"2\"]]";
		
		str = str.replace("[", "{");
		str = str.replace("]", "}");
		
		System.out.println(str);
	}

}
