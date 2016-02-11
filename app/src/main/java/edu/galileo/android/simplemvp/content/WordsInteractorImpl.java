package edu.galileo.android.simplemvp.content;

/**
 * Created by ykro.
 */
public class WordsInteractorImpl implements WordsInteractor {
    ContentRepository contentRepository;

    public WordsInteractorImpl() {
        contentRepository = ContentRepositoryImpl.getInstance();
    }

    @Override
    public void getWords() {
        contentRepository.getWords();
    }
}
