<template>
  <div>
    <div class="container">
      <h1>Delete Product</h1>
      <div class="containerCrud">
        <div class="containerCrud one">
          <table>
            <tr>
              <td></td>
              <td></td>
            </tr>
          </table>
        </div>
        <div class="containerCrud two"></div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
    
}
</script>

<style scoped>
.container {
  width: 95%;
  height: auto;
  margin-bottom: 2em;
  margin-top: 2em;
  margin-left: 1em;
  border: 5px solid black;
  padding-top: 1em;
  padding-bottom: 1em;
}
.containerCrud {
  width: 95%;
  height: auto;
  margin-bottom: 2em;
  margin-left: 1em;
  padding-top: 1em;
  padding-bottom: 1em;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows: auto;
}
.one {
  grid-column: span 2;
}
.two {
  grid-template-columns: span 1;
}
</style>
