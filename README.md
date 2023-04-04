# LeetCode challenge tracker

The purpose of the challenge is to push its participants to solve algorithmic
problems. This app creates a current week statistics dashboard 
to track the progress.

## Challenge rules
 - 6 or more tasks should be solved every week. 
 - Week is considered to be 00:00 UTC Mon - 23:59 UTC Sun.
 - Daily tasks are preferable.
 - All solved tasks should include no more than a half of easy ones.
Penalties are set by participants though must be strict.
   
## App

The app consists of a few components:

- Java 17 Spring boot based backend
- Python proxy for graphql calls
- Reactjs frontend

A packaged frontend + backend jar is supposed to be built using scripts 
in the `build` folder.

![Main page](https://imgur.com/ct9PKBL.png)