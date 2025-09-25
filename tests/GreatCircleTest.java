import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class GreatCircleTest {
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

    static Stream<Arguments> provideArgs() {
      return Stream.of(
          Arguments.of((Object) new String[]{"42.02", "87.80", "41.90", "-12.48", "7740.605988456187"}),
          Arguments.of((Object) new String[]{"64.50", "165.41", "-37.81", "-144.96", "12170.524321839686"}), // Gnome to Melbourne
          Arguments.of((Object) new String[]{"35.68", "-139.65", "35.69", "-139.66", "1.432528928010"}) // Tokyo +0.01 degrees 
      );
    }

    @ParameterizedTest
    @DisplayName("Calculates great-circle distance between two points (longitude and latitude)")
    @MethodSource("provideArgs")
    public void calculatesGreatCircleDistance(String[] args) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String expected = args[args.length - 1] + " kilometers"; 
        GreatCircle.main(Arrays.copyOfRange(args, 0, args.length - 1));
        assertEquals(expected, out.toString().trim());
    }
}

