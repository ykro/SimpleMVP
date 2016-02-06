package edu.galileo.android.simplemvp.content;

/**
 * Created by ykro.
 */
public class NamesInteractorImpl implements NamesInteractor {
    ContentRepository contentRepository;

    public NamesInteractorImpl() {
        contentRepository = ContentRepositoryImpl.getInstance();
    }

    @Override
    public void getNames() {
        contentRepository.getNames();
    }
}
