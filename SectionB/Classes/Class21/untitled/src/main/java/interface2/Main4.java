package interface2;

import java.util.HashSet;
import java.util.Set;

public class Main4 {
    public static void main(String[] args) {
        String longString="Final Year Project is one of the most important events of the Computer Science degree. It allows students to demonstrate various skills and knowledge acquired during courses and integrates material learned through several course units. The final year project exhibition is a hugely enriching experience for the students, both from a technical and personal point of view. It allows them to present their technical skills to a wide range of diversified guests from industry, academia, alumni, faculty, and students from different departments.\n" +
                "In this regard, the Department of Computer Science is organizing Final Year Project Evaluation and Exhibition Spring 2024, in which final year students of BSCS and BSSE will demonstrate their projects, 58 in total.\n" +
                "This will be a one-day activity, and the exhibition and Evaluation will start and conclude on the same day, i.e., June 25, 2024. \n";


        String array[];
        array=longString.split(" ");
        for(String s:array)
            System.out.println(s);

        System.out.println(array.length);

        Set words=new HashSet();
        for(int i=0;i< array.length;i++)
            words.add(array[i]);

        System.out.println(words.size());


    }
}
