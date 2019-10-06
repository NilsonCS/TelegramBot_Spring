package com.bot.bot.transformer;

public interface Transformer<FROM, TO> {
    TO transform(FROM chat);
}
