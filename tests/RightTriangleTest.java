import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class RightTriangleTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
      originalOut = System.out;
      System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown() {
      System.setOut(originalOut);
    }

    static Stream<Arguments> provideRightTriangleArgs() {
      return Stream.of(
          Arguments.of((Object) new String[]{"3", "4", "5"}),
          Arguments.of((Object) new String[]{"61", "11", "60"}),
          Arguments.of((Object) new String[]{"53", "45", "28"}),
          Arguments.of((Object) new String[]{"8", "15", "17"}) 
      );
    }

    static Stream<Arguments> provideOrderArgs() {
      return Stream.of(
          Arguments.of((Object) new String[]{"3", "4", "5"}),
          Arguments.of((Object) new String[]{"4", "3", "5"}),
          Arguments.of((Object) new String[]{"5", "3", "4"}),
          Arguments.of((Object) new String[]{"5", "12", "13"}),
          Arguments.of((Object) new String[]{"12", "5", "13"}),
          Arguments.of((Object) new String[]{"13", "5", "12"})
      );
    }

    static Stream<Arguments> provideNonRightArgs() {
      return Stream.of(
          Arguments.of((Object) new String[]{"3", "7", "5"}),
          Arguments.of((Object) new String[]{"5", "12", "14"}),
          Arguments.of((Object) new String[]{"15", "8", "16"}) 
      );
    }

    static Stream<Arguments> provideNegativeArgs() {
      return Stream.of(
          Arguments.of((Object) new String[]{"-3", "4", "5"}),
          Arguments.of((Object) new String[]{"5", "-12", "-13"}),
          Arguments.of((Object) new String[]{"-8", "-15", "17"}) 
      );
    }

    static Stream<Arguments> provideOverflowArgs() {
      return Stream.of(
          Arguments.of((Object) new String[]{"6276192", "2075576", "40056"}),
          Arguments.of((Object) new String[]{"65536", "37968", "37968"})
      );
    }

    @ParameterizedTest
    @DisplayName("Identifies right triangles")
    @MethodSource("provideRightTriangleArgs")
    public void identifiesRightTriangles(String[] args) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        RightTriangle.main(args);
        assertEquals("true", out.toString().trim());
    }

    @ParameterizedTest
    @DisplayName("Insensitive to order of sides")
    @MethodSource("provideOrderArgs")
    public void insensitiveToSideOrder(String[] args) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        RightTriangle.main(args);
        assertEquals("true", out.toString().trim());
    }

    @ParameterizedTest
    @DisplayName("Returns false if triangle is not right")
    @MethodSource("provideNonRightArgs")
    public void returnsFalseIfTriangleIsNotRight(String[] args) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        RightTriangle.main(args);
        assertEquals("false", out.toString().trim());
    }

    @ParameterizedTest
    @DisplayName("Returns false if any side is negative")
    @MethodSource("provideNegativeArgs")
    public void returnsFalseIfAnySideIsNegative(String[] args) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        RightTriangle.main(args);
        assertEquals("false", out.toString().trim());
    }

    @ParameterizedTest
    @DisplayName("Handles very long sides (overflow)")
    @MethodSource("provideOverflowArgs")
    public void handlesOverflowFalsePositives(String[] args) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        RightTriangle.main(args);
        assertEquals("false", out.toString().trim());
    }
}
