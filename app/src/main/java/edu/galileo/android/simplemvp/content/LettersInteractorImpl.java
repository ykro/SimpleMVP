package edu.galileo.android.simplemvp.content;

/**
 * Created by ykro.
 */
public class LettersInteractorImpl implements LettersInteractor {
    ContentRepository contentRepository;

    public LettersInteractorImpl() {
        contentRepository = ContentRepositoryImpl.getInstance();
    }

    @Override
    public void getLetters() {
        contentRepository.getLetters();
    }
}
