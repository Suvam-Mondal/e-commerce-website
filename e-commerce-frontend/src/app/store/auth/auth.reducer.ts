import { createReducer } from "@ngrx/store";
import { initialAuthState } from "../state.selector";
import { on } from "@ngrx/store";
import { login, loginFailure, loginSuccess, logout } from "./auth.action";


export const authReducer = createReducer(
    initialAuthState,
    
    on(loginSuccess, (state, props) => {
        return {
            ...state,
            isAuthenticated: true,
            authInfo: props.user
        }
    }),
    on(loginFailure, (state) => ({
        ...state,
        isAuthenticated: false,
        authInfo: null
    })),
    on(logout, (state) => ({
        ...state,
        isAuthenticated: false,
        authInfo: null,
    })),
);