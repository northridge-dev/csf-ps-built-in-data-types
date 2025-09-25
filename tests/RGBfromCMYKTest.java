import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class RGBfromCMYKTest {
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

    static Stream<Arguments> provideCMYKTestData() {
      return Stream.of(
          Arguments.of(new String[]{"0.18", "0.32", "0.0", "0.29"}, new String[]{"148", "123", "181"}),
          Arguments.of(new String[]{"1.0", "0.58", "0.0", "0.33"}, new String[]{"0", "71", "170"}),
          Arguments.of(new String[]{"0.0", "0.0", "0.0", "0.0"}, new String[]{"255", "255", "255"}),
          Arguments.of(new String[]{"1.0", "1.0", "1.0", "1.0"}, new String[]{"0", "0", "0"}),
          Arguments.of(new String[]{"0.5", "0.5", "0.5", "0.5"}, new String[]{"63", "63", "63"})
      );
    }

    @ParameterizedTest
    @DisplayName("Converts CMYK to RGB")
    @MethodSource("provideCMYKTestData")
    public void convertsToRGB(String[] args, String[] expectedRGB) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String expected = String.format("red   = %s\ngreen = %s\nblue  = %s", expectedRGB[0], expectedRGB[1], expectedRGB[2]);
        RGBfromCMYK.main(args);
        assertEquals(expected, out.toString().trim());
    }
}
