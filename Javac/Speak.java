import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import java.util.List;
import java.util.Locale;

public class NamePronouncer {
    public static void pronounceNames(List<String> names) {
        try {
            // Set up the speech synthesizer
            // Using the default voice for the system locale
            System.setProperty(
                "javax.speech.supports.audio.management", "true"
            );
            System.setProperty(
                "javax.speech.supports.audio.volume", "true"
            );

            // Create a synthesizer for the default locale
            Synthesizer synthesizer = Central.createSynthesizer(
                new SynthesizerModeDesc(Locale.getDefault())
            );

            // Allocate the synthesizer and resume it
            synthesizer.allocate();
            synthesizer.resume();

            // Pronounce each name
            for (String name : names) {
                // Construct the full phrase to be spoken
                String phrase = "Shoutout to " + name;
                
                // Speak the phrase
                synthesizer.speakPlainText(phrase, null);
                
                // Wait for the speech to complete
                synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
            }

            // Clean up
            synthesizer.deallocate();

        } catch (Exception e) {
            System.err.println("Error in text-to-speech: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // List of names to pronounce
        List<String> namesList = List.of("Rahul", "Nishant", "Harry");
        
        // Call the method to pronounce names
        pronounceNames(namesList);
    }
}