import { createReducer, on } from "@ngrx/store";
import { addToCartAction, loadCartItems, removeFromCartAction, resetCartList } from "./cart.action";
import {  } from "./cart.selector";
import { ShoppingCartModel } from "../../shared/shopping-cart.model";
import { initialCartState } from "../state.selector";



export const cartReducer = createReducer(
    initialCartState,
    on(addToCartAction, (state, product) => {

        let productToAdd: ShoppingCartModel = {
            product: product.product,
            quantity: 1
          };

        const existingCartItemIndex  = state.cartItems.findIndex(item => item.product.document_id === productToAdd.product.document_id);

        if(existingCartItemIndex !== -1) {
            console.log("Product already exists in cart, update quantity");

            let updatedCartItems = [...state.cartItems]; // Create a copy of the array
            let existingItem = { ...updatedCartItems[existingCartItemIndex] }; // Create a copy of the item
            existingItem.quantity++;
            updatedCartItems[existingCartItemIndex] = existingItem;
            localStorage.setItem('shoppingCartList', JSON.stringify(updatedCartItems));
             return {
                ...state,
                cartItems: updatedCartItems
              };
           
        } else {
            console.log("New Product");
            let updatedCartItems = [...state.cartItems]; // Create a copy of the array
            updatedCartItems.push(productToAdd);
            localStorage.setItem('shoppingCartList', JSON.stringify(updatedCartItems));
            return {
                ...state,
                cartItems: updatedCartItems //[...state.cartItems, productToAdd]
            }
           
        }
    }),
   
    on(removeFromCartAction, (state, product) => {
        console.log("Action type removeFromCartAction");

        const itemId = product.itemId;
        
        const updatedCartItems = state.cartItems.map((item) => {
          if (item.product.document_id === itemId) {
            if (item.quantity > 1) {
              return {
                ...item,
                quantity: item.quantity - 1,
              };
            } else {
              return null; // Remove the item if quantity is 1
            }
          }
          return item;
          
        }).filter(item => item !== null); // Remove null items
        localStorage.setItem('shoppingCartList', JSON.stringify(updatedCartItems));
        return {
          ...state,
          cartItems: updatedCartItems,
        };
          
       
    }),

    on(loadCartItems, (state, {cartItems}) => {
      return {
        ...state,
        cartItems
      }
    }),

    on(resetCartList, (state) => {
      return {
        ...state,
        cartItems: []
      }
    })

);