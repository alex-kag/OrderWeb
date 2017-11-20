package pst.kopendakov.servlets.controller;

import pst.kopendakov.servlets.controller.Commands.*;

public enum CommandEnum {
    LOGIN {{
        this.command = new LoginCommand();
    }},
//    LOGOUT {{
//        this.command = new LogOutCommand();
//    }},
//    EDIT_WORKTASK {{
//        this.command = new EditWorkTaskCommand();
//    }},
//    LIST_WORKTASKS {{
//        this.command = new ListWorktasksCommand();
//    }},
    LIST_USERS {{
        this.command = new ListUsersCommand();
    }},
//    DELETE_WORKTASK {{
//        this.command = new DeleteWorkTaskCommand();
//    }},
//    EDIT_ATTACH {{
//        this.command = new EditAttachCommand();
//    }},
//    DELETE_ATTACH {{
//        this.command = new DeleteAttachCommand();
//    }},
//    OPEN_COMMENT {{
//        this.command = new OpenCommentCommand();
//    }},
//    SAVE_COMMENT {{
//        this.command = new SaveCommentCommand();
//    }},
//    DELETE_COMMENT {{
//        this.command = new DeleteCommentCommand();
//    }},
//    SELECT_USER {{
//        this.command = new SelectUserCommand();
//    }},
//    INSERT_ATTACH {{
//        this.command = new InsertAttachCommand();
//    }},
//    SAVE_WORKTASK {{
//        this.command = new SaveWorkTaskCommand();
//    }},
//    INSERT_WORKTASK {{
//        this.command = new InsertWorkTaskCommand();
//    }},
//    IMPORT {{
//        this.command = new ImportCommand();
//    }},
//    SAVE_ATTACH_FILE {{
//        this.command = new SaveAttachFileCommand();
//    }},
//    DOWNLOAD_ATTACH {{
//        this.command = new DownloadAttachCommand();
//    }},
//    EDIT_USER {{
//        this.command = new EditUserCommand();
//    }},
//    DELETE_USER {{
//        this.command = new DeleteUserCommand();
//    }},
//    INSERT_USER {{
//        this.command = new InsertUserCommand();
//    }},
//    SAVE_USER {{
//        this.command = new SaveUserCommand();
//    }}
    ;

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }

}
