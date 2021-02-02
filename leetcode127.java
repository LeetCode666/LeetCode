package exam;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class leetcode127 {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(wordSet.size()== 0 || !wordSet.contains(endWord))
            return 0;
        wordSet.remove(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int wordLen = beginWord.length();
        int step = 1;
        while(!queue.isEmpty()){
            int curSize = queue.size();
            for(int i = 0; i < curSize;i++){
                String word = queue.poll();
                char[] charArray = word.toCharArray();
                for(int j = 0;j<wordLen;j++){
                    char curChar = charArray[j];
                    for(char k = 'a';k<='z';k++){
                        if(k == curChar)
                            continue;
                        charArray[j] = k;
                        String nextWord = String.valueOf(charArray);
                        if(wordSet.contains(nextWord)){
                            if(nextWord.equals(endWord)){
                                return step + 1;
                            }
                            if (!visited.contains(nextWord)) {
                                queue.add(nextWord);
                                visited.add(nextWord);
                            }
                        }
                    }
                    charArray[j] = curChar;
                }
            }
            step +=1;
        }
        return 0;
    }
}
