package io.nechn.lcct.service.impl;

import io.nechn.lcct.model.SolvedTaskRecord;
import io.nechn.lcct.service.LeetCodeApiWrapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class LeetCodeApiWrapperImpl implements LeetCodeApiWrapper {

    @Override
    public Optional<List<SolvedTaskRecord>> getLatestSolvedTasksByUsername(String username) {
        return Optional.empty();
    }

}
