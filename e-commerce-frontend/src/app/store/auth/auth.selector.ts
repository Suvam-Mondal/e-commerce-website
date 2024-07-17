import { createFeatureSelector, createSelector } from "@ngrx/store";
import { AuthState } from "../state.selector";



export const userDataSelector = createSelector(
    (state: { authReducer: AuthState }) => state.authReducer,
    (authReducer: AuthState) => {
        const userDataJson = localStorage.getItem('userData');
        return userDataJson ? JSON.parse(userDataJson) : null;
    }
);
