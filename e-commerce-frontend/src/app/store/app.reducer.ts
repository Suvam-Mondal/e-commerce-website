import { createReducer, on } from '@ngrx/store';
import { AppState } from '../app.module';
import { loadAppState } from './app.action';


const initialAppState: AppState = {
  auth: { isAuthenticated: false, authInfo: null },
  product: { shouldDisplayAsList: false, sortItemsBy: '', productForCategory: [] },
  cart: { cartItems: [] }
};

export const appReducer = createReducer(
  initialAppState,
  on(loadAppState, (state, { payload }) => ({ ...state, ...payload }))
);