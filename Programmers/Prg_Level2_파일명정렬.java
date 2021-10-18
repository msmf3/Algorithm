import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Prg_Level2_파일명정렬 {

	public static void main(String[] args) {
		String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		String[] answer = solution(files);
		for(String file : answer) {
			System.out.println(file);
		}
	}
	
	public static String[] solution(String[] files) {
        ArrayList<File> fileList = new ArrayList<>();
        for(int i = 0; i < files.length; i++) {
        	String file = files[i];
        	String head = "";
        	String number = "";
        	int idx = 0;
        	while(idx < file.length()) {
        		char c = file.charAt(idx);
        		if('0' <= c && c <= '9') {
        			break;
        		}
        		++idx;
        		head += c;
        	}
        	while(idx < file.length()) {
        		char c = file.charAt(idx);
        		if(c < '0' || '9' < c) {
        			break;
        		}
        		++idx;
        		number += c;
        	}
        	String tail = file.substring(idx);
        	fileList.add(new File(head, number, tail));
        }
//        Collections.sort(fileList);
        fileList.sort(Comparator.naturalOrder());
        
        String[] answer = new String[fileList.size()];
        for(int i = 0; i < fileList.size(); i++) {
        	answer[i] = fileList.get(i).toString();
        }
        return answer;
    }
	
	static class File implements Comparable<File> {
		String head, number, tail;
		
		public File(String head, String number, String tail) {
			this.head = head;
			this.number = number;
			this.tail = tail;
		}

		@Override
		public int compareTo(File o) {
			String head1 = head.toLowerCase();
			String head2 = o.head.toLowerCase();
			if(head1.equals(head2)) {
				int num1 = Integer.parseInt(number);
				int num2 = Integer.parseInt(o.number);
				return Integer.compare(num1, num2);
			}
			return head1.compareTo(head2);
		}
		
		@Override
		public String toString() {
			return this.head + this.number + this.tail;
		}
		
	}
}
