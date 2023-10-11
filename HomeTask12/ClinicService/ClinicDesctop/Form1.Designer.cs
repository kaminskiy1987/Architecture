namespace ClinicDesktop
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.listViewClients = new System.Windows.Forms.ListView();
            this.columnHeaderId = new System.Windows.Forms.ColumnHeader();
            this.columnHeaderSurname = new System.Windows.Forms.ColumnHeader();
            this.columnHeaderFirstname = new System.Windows.Forms.ColumnHeader();
            this.columnHeaderPatronymic = new System.Windows.Forms.ColumnHeader();
            this.columnHeaderBirthday = new System.Windows.Forms.ColumnHeader();
            this.columnHeaderDocument = new System.Windows.Forms.ColumnHeader();
            this.btnUpdate = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // listViewClients
            // 
            this.listViewClients.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnHeaderId,
            this.columnHeaderSurname,
            this.columnHeaderFirstname,
            this.columnHeaderPatronymic,
            this.columnHeaderBirthday,
            this.columnHeaderDocument});
            this.listViewClients.FullRowSelect = true;
            this.listViewClients.GridLines = true;
            this.listViewClients.Location = new System.Drawing.Point(12, 12);
            this.listViewClients.MultiSelect = false;
            this.listViewClients.Name = "listViewClients";
            this.listViewClients.Size = new System.Drawing.Size(757, 398);
            this.listViewClients.TabIndex = 0;
            this.listViewClients.UseCompatibleStateImageBehavior = false;
            this.listViewClients.View = System.Windows.Forms.View.Details;
            // 
            // columnHeaderId
            // 
            this.columnHeaderId.Text = "#";
            this.columnHeaderId.Width = 50;
            // 
            // columnHeaderSurname
            // 
            this.columnHeaderSurname.Text = "Фамилия";
            this.columnHeaderSurname.Width = 180;
            // 
            // columnHeaderFirstname
            // 
            this.columnHeaderFirstname.Text = "Имя";
            this.columnHeaderFirstname.Width = 160;
            // 
            // columnHeaderPatronymic
            // 
            this.columnHeaderPatronymic.Text = "Отчество";
            this.columnHeaderPatronymic.Width = 180;
            // 
            // columnHeaderBirthday
            // 
            this.columnHeaderBirthday.Text = "Дата рождения";
            this.columnHeaderBirthday.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.columnHeaderBirthday.Width = 100;
            // 
            // columnHeaderDocument
            // 
            this.columnHeaderDocument.Text = "Документ";
            this.columnHeaderDocument.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.columnHeaderDocument.Width = 80;
            // 
            // btnUpdate
            // 
            this.btnUpdate.Location = new System.Drawing.Point(775, 12);
            this.btnUpdate.Name = "btnUpdate";
            this.btnUpdate.Size = new System.Drawing.Size(75, 23);
            this.btnUpdate.TabIndex = 1;
            this.btnUpdate.Text = "Обновить";
            this.btnUpdate.UseVisualStyleBackColor = true;
            this.btnUpdate.Click += new System.EventHandler(this.btnUpdate_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(853, 450);
            this.Controls.Add(this.btnUpdate);
            this.Controls.Add(this.listViewClients);
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "The best clinic";
            this.ResumeLayout(false);

        }

        #endregion

        private ListView listViewClients;
        private Button btnUpdate;
        private ColumnHeader columnHeaderId;
        private ColumnHeader columnHeaderSurname;
        private ColumnHeader columnHeaderFirstname;
        private ColumnHeader columnHeaderPatronymic;
        private ColumnHeader columnHeaderBirthday;
        private ColumnHeader columnHeaderDocument;
    }
}