import React from "react";
import listItems from "../../items.json";
import List from "../../components/List/index";
import "./index.css";
import Badge from "@material-ui/core/Badge";
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import { Fab } from "@material-ui/core";
import ViewStreamIcon from '@mui/icons-material/ViewStream';
 
export default class Home extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      shopItems: listItems,
      cartItems: [],
      cartHidden: true,
      balance: 120,
    };
  }
 
  render() {
    return (
      <div className="container-fluid">
        <h1 className="text-center mt-3 mb-0">Mini Commerce</h1>
        <div style={{ position: "fixed", top: 25, right: 25 }}>
          <Fab variant="extended" onClick={this.handleToggle}>
            {this.state.cartHidden ? (
              <Badge
                color="secondary"
                badgeContent={this.state.cartItems.length}
              >
                <ShoppingCartIcon />
              </Badge>
            ) : (
              <ViewStreamIcon />
            )}
          </Fab>
        </div>
        <p className="text-center text-secondary text-sm font-italic">
          (this is a <strong>class-based</strong> application)
        </p>
        <p className="text-center text-primary">
          Your Balance: <b> {this.state.balance}</b>{" "}
        </p>
        <div className="container pt-3">
          <div className="row mt-3">
            {!this.state.cartHidden ? (
              <div className="col-sm">
                <List
                  title="My Cart"
                  items={this.state.cartItems}
                  onItemClick={this.handleDeleteItemFromCart}
                ></List>
              </div>
            ) : (
              <div className="col-sm">
                <List
                  title="List Items"
                  items={this.state.shopItems}
                  onItemClick={this.handleAddItemToCart}
                  isShopList={true}
                ></List>
              </div>
            )}
          </div>
        </div>
      </div>
    );
  }
    handleAddItemToCart = (item) => {
        const check = this.balanceDikurang(item.price);
            if(check === true) {
        const newItems = [...this.state.cartItems];
        const newItem = { ...item };
        const targetInd = newItems.findIndex((it) => it.id === newItem.id);
        if (targetInd < 0) {
            newItem.inCart = true;
            newItems.push(newItem);
            this.updateShopItem(newItem, true);
        }
        this.setState({ cartItems: newItems });
        }
    }
    handleDeleteItemFromCart = (item) => {
        this.balanceDitambah(item.price)
        const existItems = [...this.state.cartItems];
        const newItem = { ...item };
        const targetInd = existItems.findIndex((it) => it.id === newItem.id);
        if(targetInd >= 0) {
            newItem.inChart = false;
            existItems.splice(targetInd, 1);
            this.updateShopItem(newItem, false);
        }
        this.setState({ cartItems: existItems });
    }

    handleToggle = () => {
        const cartHidden = this.state.cartHidden;
        this.setState({ cartHidden: !cartHidden });
        };
    
    
    updateShopItem = (item, inCart) => {
        const tempShopItems = this.state.shopItems;
        const targetInd = tempShopItems.findIndex((it) => it.id === item.id);
        tempShopItems[targetInd].inCart = inCart;
        this.setState({ shopItems: tempShopItems });
        };
    

    balanceDikurang = (price) => {
        this.state.balance -= price;
        if(this.state.balance<0) {
            alert("Balance is not sufficient");
            this.state.balance += price;
            return false;
        }
        return true;
        }
    
    balanceDitambah = (price) => {
        this.state.balance += price;
        }
}
