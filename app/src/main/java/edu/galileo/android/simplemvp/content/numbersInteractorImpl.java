package edu.galileo.android.simplemvp.content;

/**
 * Created by ykro.
 */
public class NumbersInteractorImpl implements NumbersInteractor {
    ContentRepository contentRepository;

    public NumbersInteractorImpl() {
        contentRepository = ContentRepositoryImpl.getInstance();
    }

    @Override
    public void getNumbers() {
        contentRepository.getNumbers();
    }
}
