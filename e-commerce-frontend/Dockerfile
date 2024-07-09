# Stage 1: Install dependencies
FROM node:16-alpine AS builder
WORKDIR /app
COPY package*.json ./
RUN npm install -g @angular/cli && echo "Angular CLI installed"
RUN npm install

# Stage 2: Build the application image
FROM node:alpine
WORKDIR /app
COPY --from=builder /app/node_modules /app/node_modules
COPY . .

# Define command (assuming ng executable is in node_modules/.bin/ng)
CMD [ "node_modules/.bin/ng", "serve", "--host", "0.0.0.0" ]
