package com.example.batch.jobs.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.stereotype.Component;

/**
 * Created by sskim on 2022/03/20
 * Github : http://github.com/sskim91
 */
@Slf4j
@Component
public class InactiveChunkListener implements ChunkListener {

    @Override
    public void beforeChunk(ChunkContext context) {
        log.info("Before Chunk");
    }

    @Override
    public void afterChunk(ChunkContext context) {
        log.info("After Chunk");
    }

    @Override
    public void afterChunkError(ChunkContext context) {
        log.info("After Chunk Error");
    }
}
