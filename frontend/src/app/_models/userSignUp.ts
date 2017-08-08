export class UserSignUp {

    username: string;
    password: string;
    email: string;

    constructor() {}

    toString() {
        return JSON.stringify(this);
    }

}
