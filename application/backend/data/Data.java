package application.backend.data;

import application.backend.questionSelection.QuestionSelection;

import java.util.BitSet;


public class Data {
    public static final int NUMBER_OF_QUESTIONS = 24;
    public static final int NUMBER_OF_FLAGS = 223;
    private static final QuestionAndAnswer[] questionAndAnswer = new QuestionAndAnswer[NUMBER_OF_QUESTIONS];

    static {
        questionAndAnswer[0] = new QuestionAndAnswer("blue color", new int[]{3, 4, 6, 7, 8, 9, 10, 11, 13, 14, 17, 20, 22, 25, 26, 27, 28, 33, 36, 37, 38, 39, 40, 42, 43, 44, 45, 46, 48, 49, 51, 52, 54, 56, 57, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 70, 71, 76, 79, 80, 84, 85, 88, 89, 94, 99, 101, 104, 107, 108, 110, 112, 117, 121, 122, 124, 126, 127, 129, 130, 133, 134, 135, 136, 137, 138, 139, 140, 143, 145, 146, 149, 150, 152, 154, 155, 158, 161, 162, 163, 165, 166, 167, 168, 169, 173, 174, 175, 177, 178, 179, 180, 181, 182, 183, 189, 190, 193, 195, 196, 197, 205, 206, 209, 210, 211, 212, 213, 214, 217, 219});
        questionAndAnswer[1] = new QuestionAndAnswer("green color", new int[]{0, 2, 13, 16, 18, 21, 22, 24, 27, 28, 30, 31, 32, 34, 38, 42, 44, 47, 50, 54, 55, 60, 61, 63, 70, 71, 74, 78, 80, 81, 82, 83, 87, 89, 91, 92, 93, 95, 96, 98, 100, 102, 106, 107, 109, 111, 113, 115, 116, 118, 119, 123, 124, 125, 132, 134, 141, 142, 144, 147, 148, 155, 157, 160, 163, 164, 167, 170, 171, 172, 174, 175, 179, 181, 182, 186, 187, 188, 192, 194, 195, 199, 204, 207, 214, 215, 221, 222});
        questionAndAnswer[2] = new QuestionAndAnswer("yellow color", new int[]{3, 4, 5, 6, 7, 9, 10, 14, 17, 19, 20, 21, 22, 23, 24, 25, 27, 28, 29, 31, 34, 36, 38, 39, 41, 42, 43, 44, 50, 52, 55, 57, 58, 61, 63, 70, 73, 74, 78, 79, 81, 82, 83, 96, 99, 101, 103, 111, 114, 117, 119, 123, 124, 127, 129, 132, 134, 135, 143, 149, 151, 154, 157, 160, 161, 163, 164, 165, 166, 167, 170, 172, 174, 179, 181, 182, 184, 185, 186, 188, 190, 194, 195, 197, 198, 199, 205, 206, 208, 209, 212, 213, 215, 216, 217, 218, 222});
        questionAndAnswer[3] = new QuestionAndAnswer("red color", new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 15, 16, 18, 19, 20, 21, 22, 24, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 43, 44, 45, 46, 48, 49, 51, 53, 54, 55, 56, 57, 58, 60, 61, 63, 64, 65, 66, 68, 69, 71, 72, 73, 74, 75, 77, 78, 79, 81, 82, 83, 84, 86, 87, 88, 90, 91, 92, 95, 97, 98, 100, 101, 102, 103, 104, 105, 106, 108, 110, 111, 112, 114, 115, 116, 117, 118, 119, 120, 122, 124, 125, 127, 128, 129, 130, 131, 132, 133, 134, 136, 137, 138, 139, 143, 145, 146, 147, 150, 151, 152, 153, 154, 155, 156, 157, 158, 160, 161, 162, 164, 166, 168, 170, 172, 173, 174, 176, 177, 178, 181, 182, 183, 184, 185, 186, 187, 188, 189, 191, 192, 193, 194, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 210, 211, 213, 215, 217, 218, 219, 220, 221, 222});
        questionAndAnswer[4] = new QuestionAndAnswer("white color", new int[]{0, 2, 3, 6, 7, 8, 11, 12, 13, 15, 18, 20, 22, 23, 25, 26, 27, 28, 29, 30, 32, 33, 35, 36, 37, 38, 40, 42, 44, 45, 46, 47, 48, 49, 50, 51, 53, 54, 55, 56, 58, 59, 60, 62, 64, 65, 66, 67, 68, 69, 71, 72, 75, 76, 77, 79, 80, 83, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 97, 98, 100, 101, 102, 104, 105, 106, 107, 108, 112, 113, 115, 117, 118, 120, 121, 122, 125, 126, 128, 130, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 162, 164, 165, 166, 168, 169, 171, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 187, 188, 189, 191, 192, 193, 194, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 210, 211, 212, 213, 214, 216, 219, 220, 222});
        questionAndAnswer[5] = new QuestionAndAnswer("black color", new int[]{0, 1, 5, 7, 14, 17, 19, 26, 29, 55, 58, 62, 73, 74, 82, 83, 92, 96, 98, 100, 102, 116, 132, 151, 165, 166, 170, 181, 183, 187, 189, 192, 195, 198, 201, 207, 208, 215, 220, 221, 222});
        questionAndAnswer[6] = new QuestionAndAnswer("exactly two colors", new int[]{1, 12, 15, 16, 25, 35, 41, 52, 53, 67, 72, 76, 77, 84, 85, 86, 90, 94, 97, 99, 103, 105, 114, 123, 126, 128, 131, 142, 144, 148, 149, 153, 156, 159, 169, 171, 176, 180, 184, 185, 190, 191, 200, 202, 203, 209, 218});
        questionAndAnswer[7] = new QuestionAndAnswer("exactly three colors", new int[]{2, 5, 8, 9, 10, 11, 14, 17, 18, 19, 21, 23, 24, 26, 30, 31, 32, 33, 34, 39, 40, 43, 45, 46, 47, 48, 49, 50, 51, 56, 57, 59, 62, 64, 65, 68, 70, 73, 75, 78, 81, 87, 88, 91, 93, 95, 96, 104, 106, 108, 110, 111, 112, 113, 115, 116, 118, 119, 120, 121, 122, 127, 129, 133, 135, 136, 137, 138, 139, 140, 141, 145, 146, 150, 152, 158, 160, 161, 162, 163, 167, 168, 172, 173, 175, 177, 178, 193, 196, 201, 204, 210, 211, 212, 216, 219, 220});
        questionAndAnswer[8] = new QuestionAndAnswer("exactly four colors", new int[]{0, 4, 13, 27, 29, 36, 42, 54, 58, 61, 63, 69, 71, 74, 80, 82, 89, 92, 98, 100, 101, 102, 107, 117, 124, 125, 143, 147, 151, 154, 157, 165, 170, 179, 183, 186, 187, 188, 192, 194, 195, 198, 199, 207, 208, 214, 215, 217, 221});
        questionAndAnswer[9] = new QuestionAndAnswer("single color triangle", new int[]{3, 6, 7, 11, 14, 22, 25, 28, 32, 37, 45, 51, 60, 61, 64, 66, 78, 83, 96, 107, 114, 121, 130, 139, 143, 155, 160, 164, 170, 174, 179, 181, 182, 187, 195, 197, 201, 205, 206, 210});
        questionAndAnswer[10] = new QuestionAndAnswer("single color rectangle", new int[]{0, 4, 8, 9, 10, 12, 13, 17, 18, 19, 20, 21, 24, 26, 30, 33, 34, 35, 38, 39, 40, 43, 46, 47, 48, 53, 56, 57, 58, 59, 62, 65, 67, 68, 69, 70, 71, 73, 74, 76, 80, 81, 82, 84, 85, 87, 88, 89, 90, 91, 92, 93, 94, 95, 102, 104, 105, 106, 108, 109, 110, 111, 112, 115, 116, 117, 119, 120, 122, 124, 125, 127, 128, 129, 135, 137, 138, 140, 141, 142, 144, 145, 146, 147, 148, 150, 152, 153, 156, 161, 162, 163, 167, 169, 172, 173, 175, 176, 178, 185, 186, 188, 189, 190, 192, 194, 196, 199, 207, 208, 209, 211, 212, 214, 216, 217, 219, 220, 221});
        questionAndAnswer[11] = new QuestionAndAnswer("vertical strips only", new int[]{9, 12, 26, 30, 43, 46, 62, 70, 71, 73, 84, 87, 90, 105, 109, 111, 112, 124, 128, 137, 156, 162, 169, 173, 175, 185, 196, 209, 220});
        questionAndAnswer[12] = new QuestionAndAnswer("horizontal strips only", new int[]{19, 39, 47, 68, 81, 93, 95, 109, 119, 122, 142, 153, 161});
        questionAndAnswer[13] = new QuestionAndAnswer("exactly three strips (vertical or horizontal)", new int[]{9, 12, 19, 30, 39, 43, 47, 62, 68, 70, 73, 81, 87, 93, 95, 105, 111, 112, 119, 122, 137, 142, 153, 161, 162, 173, 175, 185, 220});
        questionAndAnswer[14] = new QuestionAndAnswer("cross", new int[]{6, 11, 28, 37, 45, 53, 56, 64, 65, 66, 67, 72, 88, 96, 130, 139, 143, 146, 155, 166, 182, 190, 191, 200, 205, 206, 210, 219});
        questionAndAnswer[15] = new QuestionAndAnswer("circle", new int[]{16, 20, 27, 37, 42, 55, 63, 64, 69, 77, 78, 89, 97, 99, 103, 104, 114, 133, 134, 141, 145, 149, 152, 163, 183, 193, 202, 208});
        questionAndAnswer[16] = new QuestionAndAnswer("more than one star", new int[]{11, 25, 32, 36, 41, 42, 44, 45, 52, 92, 113, 126, 133, 138, 139, 150, 151, 154, 164, 168, 170, 176, 179, 192, 204, 206, 211, 214, 217});
        questionAndAnswer[17] = new QuestionAndAnswer("exactly one star", new int[]{2, 5, 10, 13, 31, 34, 38, 40, 49, 54, 63, 74, 82, 94, 98, 108, 117, 123, 131, 132, 134, 135, 136, 145, 147, 148, 158, 163, 172, 180, 188, 193, 198, 199, 202, 203, 212, 218, 222});
        questionAndAnswer[18] = new QuestionAndAnswer("red top edge", new int[]{1, 5, 9, 12, 20, 24, 31, 41, 48, 58, 69, 71, 74, 78, 86, 87, 90, 92, 101, 103, 104, 105, 106, 112, 118, 124, 128, 131, 137, 152, 158, 176, 184, 185, 187, 191, 192, 194, 196, 198, 202, 203, 215, 218, 220});
        questionAndAnswer[19] = new QuestionAndAnswer("exactly two red connected space", new int[]{2, 7, 12, 18, 20, 56, 75, 77, 79, 91, 104, 105, 106, 127, 129, 138, 145, 150, 152, 153, 157, 177, 178, 185, 186, 189, 196, 200, 201, 208, 219});
        questionAndAnswer[20] = new QuestionAndAnswer("exactly five red connected space", new int[]{0, 6, 11, 28, 32, 37, 45, 64, 69, 72, 130, 143, 155, 182, 205, 206, 210});
        questionAndAnswer[21] = new QuestionAndAnswer("exactly two blue connected space", new int[]{3, 8, 14, 17, 25, 26, 27, 33, 36, 46, 56, 57, 80, 89, 121, 127, 135, 145, 150, 152, 177, 178});
        questionAndAnswer[22] = new QuestionAndAnswer("exactly one blue connected space", new int[]{4, 7, 9, 13, 20, 39, 40, 42, 43, 44, 48, 51, 52, 54, 60, 61, 62, 67, 68, 70, 71, 84, 104, 107, 108, 110, 112, 117, 122, 124, 126, 133, 134, 136, 137, 138, 146, 149, 154, 158, 161, 162, 163, 165, 166, 167, 168, 169, 173, 174, 175, 179, 180, 181, 183, 193, 195, 196, 209, 211, 214, 217, 219});
        questionAndAnswer[23] = new QuestionAndAnswer("at least one white rectangle", new int[]{12, 26, 30, 38, 40, 46, 47, 62, 65, 67, 68, 71, 76, 87, 90, 93, 95, 102, 105, 108, 112, 115, 122, 128, 137, 138, 142, 145, 147, 148, 153, 156, 162, 169, 173, 175, 176, 188, 196, 207, 211, 212, 214, 220});
    }

    public static boolean getAnswer(int question, int flag) {
        return questionAndAnswer[question].getAnswer(flag);
    }

    public static String getQuestion(int question) {
        return questionAndAnswer[question].getQuestion();
    }

}


