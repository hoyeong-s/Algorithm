import java.io.*;
import java.util.*;

public class convert {

	public static void main(String[] args) {
		String str = "[[\"POOOP\", \"OXXOX\", \"OPXPX\", \"OOXOX\", \"POXXP\"], [\"POOPX\", \"OXPXP\", \"PXXXO\", \"OXXXO\", \"OOOPP\"], [\"PXOPX\", \"OXOXP\", \"OXPOX\", \"OXXOP\", \"PXPOX\"], [\"OOOXX\", \"XOOOX\", \"OOOXX\", \"OXOOX\", \"OOOOO\"], [\"PXPXP\", \"XPXPX\", \"PXPXP\", \"XPXPX\", \"PXPXP\"]]";
		
		str = str.replace("[", "{");
		str = str.replace("]", "}");
		
		System.out.println(str);
	}

}
