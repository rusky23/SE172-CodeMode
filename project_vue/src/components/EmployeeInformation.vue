<template>
<b-container fluid>
<br>
<b-alert show variant="primary">Employees Information</b-alert>
  <div class="text-center">
    <b-btn v-b-modal.addEmployee>Add Employee</b-btn>
    <b-modal id="addEmployee"
             ref="modalAddEmployee"
             title="Enter Employee Information"
             ok-title='Submit'
             @ok="submitAddEmployee"
             @shown="clearEmployee">
      <form @submit.stop.prevent="handleSubmitAddEmployee">
        <b-container fluid>
            <div role="group">
              <label for="formName">Full Name:</label>
              <b-form-input id="formName" v-model.trim="name" type="text" :state="nameState" aria-describedby="formNameFeedback"></b-form-input>
              <b-form-invalid-feedback id="formNameFeedback">
                Enter a Name
              </b-form-invalid-feedback>
            </div>
            <br>
            <div role="group">
              <label for="formName">Gender:</label>
              <select v-model="gender" class="required">
                <option disabled value="">Gender</option>
                <option>Male</option>
                <option>Female</option>
              </select>
              <b-form-invalid-feedback id="formGenderFeedback">
                Enter either 'Male' or 'Female'
              </b-form-invalid-feedback>
            </div>
            <br>
            <div role="group">
              <label for="formBirth">Birth Date:</label>
              <b-form-input id="formBirth" v-model.trim="birth" type="date" :state="birthState" aria-describedby="formBirthFeedback"></b-form-input>
              <b-form-invalid-feedback id="formBirthFeedback">
                Enter a valid date
              </b-form-invalid-feedback>
            </div>
        </b-container>
      </form>
    </b-modal>
  </div>
 <br>
  <div>
    <vue-good-table
      :columns="columns"
      :rows="rows"
      :search-options="{
        enabled: true,
        placeholder: 'Search Employees by Name or Number ...'
      }"
      :pagination-options="{
        enabled: true,
        perPage: 10,
      }"
      :lineNumbers="true"
      @on-cell-click="onCellClick"
      styleClass="vgt-table striped bordered"/>
  </div>
  <b-modal v-model="deleteModal" id="deleteModal" centered title="Delete Employee" ok-title='Delete' ok-variant='danger' @ok="deleteEmployee">
    Deletion cannot be undone. Delete this Employee?
  </b-modal>
  <b-modal v-model="modifyNameModal" id="modifyNameModal" centered title="Update Employee Name" @ok="updateEmployee">
    <div role="group">
      <label for="formName">Full Name:</label>
      <b-form-input id="formName" v-model.trim="name" type="text" :state="nameState" aria-describedby="formNameFeedback"></b-form-input>
      <b-form-invalid-feedback id="formNameFeedback">
        Enter a New Name
      </b-form-invalid-feedback>
    </div>
  </b-modal>
  <b-modal v-model="modifyGenderModal" id="modifyGenderModal" centered title="Update Employee Gender" @ok="updateEmployee">
    <div role="group">
      <label for="formName">Gender:</label>
      <select v-model="gender" class="required">
        <option disabled value="">Gender</option>
        <option>Male</option>
        <option>Female</option>
      </select>
      <b-form-invalid-feedback id="formGenderFeedback">
        Enter either 'Male' or 'Female'
      </b-form-invalid-feedback>
    </div>
  </b-modal>
  <b-modal v-model="modifyBirthModal" id="modifyBirthModal" centered title="Update Employee Birth Date" @ok="updateEmployee">
    <div role="group">
      <label for="formBirth">Birth Date:</label>
      <b-form-input id="formBirth" v-model.trim="birth" type="date" :state="birthState" aria-describedby="formBirthFeedback"></b-form-input>
      <b-form-invalid-feedback id="formBirthFeedback">
        Enter a valid date
      </b-form-invalid-feedback>
    </div>
  </b-modal>
</b-container>
</template>

<style>
</style>

<script>
  export default {
    data: () => ({
      SelectedText: '',
      modifyNameModal: false,
      modifyGenderModal: false,
      modifyBirthModal: false,
      deleteModal: false,
      columns: [
        {
          label: 'Employee Number',
          field: 'Emp_no',
          filterOptions: { enabled: true
          },
          type: 'number',
          thClass: 'vgt-left-align',
          tdClass: 'vgt-left-align'
        },
        {
          label: 'Full Name',
          field: 'FullName',
          filterOptions: { enabled: true
          },
          thClass: 'vgt-left-align',
          tdClass: 'vgt-left-align'
        },
        {
          label: 'Gender',
          field: 'Gender',
          thClass: 'vgt-left-align',
          tdClass: 'vgt-left-align'
        },
        {
          label: 'Birth Date',
          field: 'BirthDate',
          type: 'date',
          dateInputFormat: 'YYYY-MM-DD',
          dateOutputFormat: 'Do MMM YYYY',
          thClass: 'vgt-left-align',
          tdClass: 'vgt-left-align'
        },
        {
          label: 'Delete',
          field: 'del',
          html: true,
          sortable: false,
          thClass: 'vgt-center-align',
          tdClass: 'vgt-center-align'}
      ],
      rows: [],
      selectedIndex: null,
      employee: null,
      name: '',
      birth: '',
      gender: '',
      deleteAction: "<button type='button' class='btn btn-danger btn-md'> Delete </button>"
    }),
    computed: {
      nameState () {
        return Boolean(this.name)
      },
      genderState () {
        return Boolean(this.gender)
      },
      birthState () {
        return Boolean(this.birth)
      }
    },
    mounted () {
      this.axios.get('http://www.topcutbarbers.co.uk/service/service.php').then((response) => {
        this.rows = response.data
        for (var row in this.rows) {
          this.rows[row].del = this.deleteAction
        }
      })
    },
    methods: {
      onCellClick (params) {
        this.selectedIndex = params.row.originalIndex
        this.name = this.rows[this.selectedIndex].FullName
        this.gender = this.rows[this.selectedIndex].Gender
        this.birth = this.rows[this.selectedIndex].BirthDate
        if (params.column.field === 'del') {
          this.deleteModal = true
        } else if (params.column.field === 'FullName') {
          this.modifyNameModal = true
        } else if (params.column.field === 'Gender') {
          this.modifyGenderModal = true
        } else if (params.column.field === 'BirthDate') {
          this.modifyBirthModal = true
        }
      },
      createEmployee () {
        var nextEmpNo = Number(this.rows[this.rows.length - 1].Emp_no) + 1
        this.employee = {
          Emp_no: nextEmpNo,
          FullName: this.name,
          BirthDate: this.birth,
          Gender: this.gender,
          del: this.deleteAction
        }
      },
      updateEmployee (evt) {
        // Prevent modal from closing
        evt.preventDefault()

        if (!this.nameState || !this.genderState || !this.birthState) {
          alert('Please fill in the field.')
        } else {
          this.handleUpdateEmployee()
        }
      },
      handleUpdateEmployee () {
        this.rows[this.selectedIndex].FullName = this.name
        this.rows[this.selectedIndex].Gender = this.gender
        this.rows[this.selectedIndex].BirthDate = this.birth

        this.clearEmployee()
        this.modifyNameModal = false
        this.modifyGenderModal = false
        this.modifyBirthModal = false
      },
      clearEmployee () {
        this.employee = null
        this.name = ''
        this.birth = ''
        this.gender = ''
      },
      submitAddEmployee (evt) {
        // Prevent modal from closing
        evt.preventDefault()
        this.createEmployee()

        if (!this.nameState || !this.genderState || !this.birthState) {
          alert('Please fill out all required fields.')
        } else if (!this.employee) {
          alert('Employee entered has a problem.')
          console.log('error with employee:', this.employee)
        } else {
          this.handleSubmitAddEmployee()
        }
      },
      handleSubmitAddEmployee () {
        this.rows.push(this.employee)
        console.log('Submitted employee:', this.employee)
        this.clearEmployee()
        this.$refs.modalAddEmployee.hide()
      },
      deleteEmployee () {
        if (this.selectedIndex || this.selectedIndex === 0) {
          this.rows.splice(this.selectedIndex, 1)
        } else {
          alert('Could not delete Employee')
        }
      }
    }
  }
</script>
