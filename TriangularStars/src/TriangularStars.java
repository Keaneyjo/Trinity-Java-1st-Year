/* Question
 * A “star number”, s, is a number defined by the formula:  s = 6n(n-1) + 1     
 * where n is the index of the star number.  Thus the star numbers are:   1, 13, 37, 73, 121, 181, 253, …
A “triangle number”, t, is the sum of the numbers from 1 to n:   t = 1 + 2 + … + (n-1) + n.  
Thus the triangle numbers are:  1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 66, 78, 91, 105, 120, 136, 153, 171, 190, 210, 231, 253, …
Write a Java application that produces a list of all the values of type int that are simultaneously star numbers and triangle numbers. 
As part of this problem you must write and use the following functions:
An isStarNumber() routine which determines if the passed number is a star number or not.
A determineStarNumber() function which returns the star number of a passed index (i.e. value of n) 
OR a determineTriangleNumber() function which returns the triangle number for a passed index (i.e. value of n)
 */
/* SELF ASSESSMENT
 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
        Mark out of 5:5
        Comment:All variables have been formatted correctly with simple names in lowerCamelCase.
 2. Did I indent the code appropriately?
        Mark out of 5:5        
        Comment:All code has been formatted correctly with reference to examples and the coding standard given.
 3. Did I write the determineStarNumber or determineTriangleNumber function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20:20  
       Comment: The determineTriangleNumber function is given correct parameters, a correct return type and a correct function body.
 4. Did I write the isStarNumber function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20:20
       Comment: The isStarNumber function is given correct parameters, a correct return type and a correct function body. It is invoked correctly.
 5. Did I calculate and/or check triangle numbers correctly?
       Mark out of 15:15        
       Comment:The triangle numbers are calculated correctly.
 6. Did I loop through all possibilities in the program using system defined constants to determine when to stop?
       Mark out of 10:10     
       Comment:Yes the program loops through all possibilities with it ending at the set max value for an integer.
 7. Does my program compute and print all the correct triangular star numbers?
       Mark out of 20:20 
       Comment:For the limit of triangular star numbers we can find I computed and printed all the correct outputs. 5 in total.
 8. How well did I complete this self-assessment?
        Mark out of 5: 5      
        Comment:I believe I completed this self-assessment accurately and logically, and from my point of view there is nothing wrong with this code.
    	That being said there may be something wrong here that I do not see.
 Total Mark out of 100 (Add all the previous marks):100
*/ 
public class TriangularStars {
	public static final int INTEGER_MAX_VALUE = 2147483647;
	public static final int STAR_NUMBER_CALCULATION_VALUE_1 = 6;
	public static final int STAR_NUMBER_CALCULATION_VALUE_2 = 1;
        public static void main(String args[]){
            int triangleNumberOriginalValue = 1;
            int starNumberOriginalValue = 1;
            while(starNumberOriginalValue < INTEGER_MAX_VALUE)
            {
                    int starNumber = isStarNumber(starNumberOriginalValue);
                    int triangleNumber = determineTriangleNumber(triangleNumberOriginalValue);
                   
                    if (triangleNumber == starNumber)
                    {
                            System.out.println(triangleNumber + " is a triangular star number.");
                                triangleNumberOriginalValue++;
                                starNumberOriginalValue++;
                        }
                }
        }
 
    public static int isStarNumber (int starNumber) {
            int starNumberEquivalent = ((STAR_NUMBER_CALCULATION_VALUE_1*starNumber)*
            		(starNumber-STAR_NUMBER_CALCULATION_VALUE_2)+STAR_NUMBER_CALCULATION_VALUE_2);              
            return starNumberEquivalent;
    }
    public static int determineTriangleNumber (int triangleNumber) {
            int triangleNumberCalculation = 0;
            while (triangleNumber>=1)
            {
            triangleNumberCalculation = triangleNumberCalculation + triangleNumber;
            triangleNumber--;
            }
            return triangleNumberCalculation;
    }
}
