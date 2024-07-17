import { createAction, props } from "@ngrx/store";
import { UserModel } from "../../shared/user.model";
import { AuthModel } from "../../shared/auth.model";

export const login = createAction("login", props<{ auth: AuthModel, action: string }>());
export const loginSuccess = createAction("loginSuccess", props<{ user: UserModel }>());
export const loginFailure = createAction("loginFailure", props<{ error: string }>());

export const logout = createAction("logout");


