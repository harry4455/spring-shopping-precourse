package shopping.product;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class DisplayedNameTest {

    @Test
    void 이름에_비속어가_포함되어_있으면_예외가_발생한다() {
        final Profanities profanities = new FakeProfanities();
        final String name = "욕설";
        assertThatIllegalArgumentException().isThrownBy(() -> new DisplayedName(name, profanities));
    }

    @Test
    void 동등성(){
        final Profanities profanities = new FakeProfanities();
        final var name1 = assertThat(new DisplayedName("아메리카노", profanities));
        final var name2 = assertThat(new DisplayedName("아메리카노", profanities));
        assertThat(name1).isEqualTo(name2);
    }

    class FakeProfanities implements Profanities {

        private final List<String> values = List.of("욕설", "비속어");

        @Override
        public boolean contains(String text) {
            return false;
        }
    }
}
