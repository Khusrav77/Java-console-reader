package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.OutputMessage;

public interface CommandHandler {

    OutputMessage handle(Command command);
}
