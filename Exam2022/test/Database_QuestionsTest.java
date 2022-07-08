import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Database_QuestionsTest {


    Database_Questions DQ = new Database_Questions();

    @Test
    void BQtest() throws SQLException {
        ArrayList<BinaryQuiz> testArray = DQ.BQ();

        assertEquals("n", testArray.get(0).getCorrectAnswer());
    }
    @Test
    void MQtest() throws SQLException {
        ArrayList<MultichoiceQuiz> testArray = DQ.MQ();

        assertEquals("b", testArray.get(0).getCorrectAnswer());

        assertEquals("a", testArray.get(3).getCorrectAnswer());

        assertEquals("What was Genghis Khan known for", testArray.get(2).getQuestion());
    }

}