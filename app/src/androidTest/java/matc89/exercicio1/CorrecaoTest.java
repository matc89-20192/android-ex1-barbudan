package matc89.exercicio1;

import android.content.pm.ActivityInfo;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.rule.ActivityTestRule;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.action.ViewActions.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CorrecaoTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void textoInicial() {
        onView(withId(R.id.editNome))
                .check(matches(withText("")));
        onView(withId(R.id.labelMensagem))
                .check(matches(withText("Alô, Mundo!")));
    }

    @Test
    public void mudaTexto() {
        onView(withId(R.id.editNome))
                .perform(typeText("1234"));

        onView(withId(R.id.btnCumprimentar))
                .perform(click());

        onView(withId(R.id.labelMensagem))
                .check(matches(withText("Alô, 1234!")));
    }

    @Test
    public void mantemLabelECaixaDeTextoAposRotacao() {
        onView(withId(R.id.editNome))
                .perform(typeText("1234"));

        onView(withId(R.id.btnCumprimentar))
                .perform(click());

        onView(withId(R.id.editNome))
                .perform(typeText("56"));

        mActivityRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        onView(withId(R.id.labelMensagem))
                .check(matches(withText("Alô, 1234!")));
        onView(withId(R.id.editNome))
                .check(matches(withText("123456")));
    }
}
