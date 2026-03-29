package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.Result;

public interface CommandHandler {

    Result handle(Command command);
}
